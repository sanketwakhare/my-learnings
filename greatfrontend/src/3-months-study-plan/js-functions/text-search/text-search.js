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
  if (query.length === 0 || text.length === 0) {
    return text;
  }

  const lowerText = text.toLowerCase();
  const lowerQuery = query.toLowerCase();
  const isMatch = new Array(text.length).fill(false);

  for (let i = 0; i <= lowerText.length - lowerQuery.length; i++) {
    if (lowerText.substring(i, i + lowerQuery.length) === lowerQuery) {
      for (let j = 0; j < lowerQuery.length; j++) {
        isMatch[i + j] = true;
      }
      i += lowerQuery.length - 1;
    }
  }

  let result = "";
  for (let i = 0; i < text.length; i++) {
    if (isMatch[i]) {
      let j = i + 1;
      while (j < text.length && isMatch[j]) {
        j++;
      }
      result += "<b>" + text.substring(i, j) + "</b>";
      i = j - 1;
      continue;
    }
    result += text[i];
  }

  return result;
}
