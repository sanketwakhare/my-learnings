/**
 * Implement a function to highlight text if a searched term appears within it

In browsers, we are able to find specific words or phrases within a webpage by using Ctrl + F (Windows, Linux) or ⌘ + F (Mac) and entering the search term. Matches which appear will be highlighted in yellow.
Let's implement a simple version of a browser's in-webpage search with the difference being we're given a string (as opposed to HTML) and search matches appear bolded.
Given a content string and a query string, implement a function textSearch that finds all case-insensitive matches with the query string, wrapping the matches in <b>...</b> tags.

Examples

textSearch('The Quick Brown Fox Jumps Over The Lazy Dog', 'fox');
// 'The Quick Brown <b>Fox</b> Jumps Over The Lazy Dog'

textSearch('The hardworking Dog overtakes the lazy dog', 'dog');

// 'The hardworking <b>Dog</b> overtakes the lazy <b>dog</b>'
A character will not match the same query more than once, with letters appearing earlier taking priority.

textSearch('aaa', 'aa');
// '<b>aa</b>a'
// This is because the second character cannot be used as a match again.
Consecutive matches should be combined into a single <b> tag.

textSearch('aaaa', 'aa');

// Correct: '<b>aaaa</b>'

// Wrong: '<b>aa</b><b>aa</b>'
 */

/**
 * @param {string} text
 * @param {string} query
 * @return {string}
 */
export default function textSearch(text, query) {
  // Handle edge cases: if either string is empty, return original text
  if (text.length === 0 || query.length === 0) {
    return text;
  }

  // Convert both strings to lowercase for case-insensitive comparison
  const textLower = text.toLowerCase();
  const queryLower = query.toLowerCase();

  // Create a binary mapping array to track which characters are part of a match
  // 0 = not matched, 1 = matched
  const binaryMapping = new Array(text.length).fill(0);

  // First pass: find all matches and mark matched characters
  for (let i = 0; i < textLower.length - queryLower.length; i++) {
    // Extract substring of the same length as query starting at position i
    const currSubStr = textLower.substring(i, i + queryLower.length);

    // Check if current substring matches the query
    if (currSubStr === queryLower) {
      // Mark all characters in this match as 1 in the binary mapping
      for (let j = 0; j < queryLower.length; j++) {
        binaryMapping[i + j] = 1;
      }

      // Skip ahead by (query.length - 1) to avoid overlapping matches
      // The -1 is because the loop will increment i by 1 anyway
      i += query.length - 1;
    }
  }

  // Second pass: build the result string with <b> tags around matched sections
  const result = [];
  for (let i = 0; i < binaryMapping.length; i++) {
    // If current character is part of a match
    if (binaryMapping[i] === 1) {
      // Find the end of this consecutive matched section
      let j = i + 1;
      while (j < text.length && binaryMapping[j] === 1) {
        j++;
      }

      // Wrap the entire matched section in <b> tags
      // This combines consecutive matches into a single bold tag
      result.push(`<b>${text.substring(i, j)}</b>`);

      // Move index to the end of this matched section (subtract 1 for loop increment)
      i = j - 1;
    } else {
      // Not a match, just add the original character
      result.push(text[i]);
    }
  }

  // Join all parts together to form the final string
  return result.join("");
}
