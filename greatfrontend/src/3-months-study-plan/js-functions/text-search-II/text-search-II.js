/**
 * Text Search II
 * 
 * In browsers, we are able to find specific words or phrases within a webpage by using Ctrl + F (Windows, Linux) or ⌘ + F (Mac) and entering the search term. Matches which appear will be highlighted in yellow.

Let's implement a simple version of a browser's in-webpage search with the difference being we're given a string (as opposed to HTML) and search matches appear bolded.

Given a string and an array of queries, implement a function textSearch that finds all case-insensitive matches from the queries array within the string, wrapping the matches in <b>...</b> tags.

Examples

textSearch('The Quick Brown Fox Jumps Over The Lazy Dog', ['fox']);
// 'The Quick Brown <b>Fox</b> Jumps Over The Lazy Dog'
textSearch('The quick brown fox jumps over the lazy dog', ['fox', 'dog']);
// 'The quick brown <b>fox</b> jumps over the lazy <b>dog</b>'
If two such queries overlap or are consecutive, they should be wrapped in a single pair of <b> tags.


textSearch('This is Uncopyrightable!', ['copy', 'right']);
// 'This is Un<b>copyright</b>able!'
textSearch('This is Uncopyrightable!', ['copy', 'right', 'table']);
// 'This is Un<b>copyrightable</b>!'
A character will not match the same query more than once, with earlier letters taking priority.


textSearch('aaa', ['aa']);
// '<b>aa</b>a'
// This is because the second character cannot be used as a match again.
textSearch('aaaa', ['aa']);
// '<b>aaaa</b>'
You can assume there are no duplicate strings in the queries array.
 */

/**
 * @param {string} text
 * @param {Array<string>} queries
 * @return {string}
 */
export default function textSearch(text, queries) {
  // Handle edge cases: if either string is empty, return original text
  if (text.length === 0 || queries.length === 0) {
    return text;
  }

  const binaryMapping = new Array(text.length).fill(0);
  const textLower = text.toLowerCase();

  for (const query of queries) {
    if (query.trim() === "") continue;

    const queryLower = query.toLowerCase();

    for (let i = 0; i <= text.length - queryLower.length; i++) {
      // Extract substring of the same length as query starting at position i
      const currSubStr = textLower.substring(i, i + queryLower.length);
      // Check substring match
      if (currSubStr === queryLower) {
        // Mark characters (even if some are already used)
        for (let j = 0; j < queryLower.length; j++) {
          binaryMapping[i + j] = 1;
        }
        i += queryLower.length - 1; // move forward
      }
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
