/**
 * Table of Contents

On websites, heading tags give a hierarchy to the page and heading information can be used by user agents (including screen readers) to construct a table of contents for a document automatically.

Given a document node, write a function tableOfContents that generates an HTML string representing a table of contents based on the headings (<h1>, <h2>, ..., <h6>) in the document. Following the best practices, heading levels won't be skipped, i.e. <h1> will be followed by <h2> and so on.

The returned string doesn't need to contain any indentation.

Examples
The example below is shown with indentation to make the output easier to understand.


const doc = new DOMParser().parseFromString(
  `<!DOCTYPE html>
  <body>
    <h1>Heading1</h1>
    <h2>Heading2a</h2>
    <h2>Heading2b</h2>
    <h3>Heading3a</h3>
    <h3>Heading3b</h3>
    <h4>Heading4</h4>
    <h2>Heading2c</h2>
  </body>`,
  'text/html',
);

const htmlString = tableOfContents(doc);
console.log(htmlString);
// Pretty-printed for readability.
`<ul>
  <li>
    Heading1
    <ul>
      <li>Heading2a</li>
      <li>
        Heading2b
        <ul>
          <li>Heading3a</li>
          <li>
            Heading3b
            <ul>
              <li>Heading4</li>
            </ul>
          </li>
        </ul>
      </li>
      <li>Heading2c</li>
    </ul>
  </li>
</ul>`;
 */

/**
 * @param {Document} doc
 * @return {string}
 */
export default function tableOfContents(doc) {
  // Get all headings in document order
  const headings = Array.from(doc.querySelectorAll("h1, h2, h3, h4, h5, h6"));

  if (headings.length === 0) {
    return "";
  }

  // Build tree structure
  const root = { level: 0, children: [] };
  const stack = [root];

  for (const heading of headings) {
    const level = parseInt(heading.tagName[1]);
    const node = {
      level,
      text: heading.textContent,
      children: [],
    };

    // Pop stack until we find the parent level
    while (stack[stack.length - 1].level >= level) {
      stack.pop();
    }

    // Add as child to current parent
    stack[stack.length - 1].children.push(node);
    stack.push(node);
  }

  // Convert tree to HTML
  function toHTML(children) {
    if (children.length === 0) return "";

    return (
      "<ul>" +
      children
        .map((node) => `<li>${node.text}${toHTML(node.children)}</li>`)
        .join("") +
      "</ul>"
    );
  }

  return toHTML(root.children);
}
