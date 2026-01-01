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
