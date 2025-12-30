/**
 * Implement a function to determine if two DOM trees are the same.
 * 
 * Two DOM trees are considered the same if they have the same structure,
 * the same tag names, the same attributes with the same values, and the same text content.
 * 
 * Implement a function identicalDOMTrees that checks if two DOM trees are identical or not. The function takes two DOM nodes as the root nodes of two DOM trees and returns a boolean result.
Two DOM trees are considered identical if they are structurally similar, and the DOM nodes on one tree have the exact same attributes as the nodes on the same relative position on the other tree.

Examples
Tree A and Tree B are considered the same.

<!-- Tree A -->
<div>Hello World</div>

<!-- Tree B -->

<div>Hello World</div>
Tree C and Tree D are considered the different.

<!-- Tree C -->
<div class="header">Hello World</div>

<!-- Tree D -->
<div id="foo">Hello World</div>
 * 
 * 
 * @param {Node} nodeA
 * @param {Node} nodeB
 * @return {boolean}
 */
export default function identicalDOMTrees(nodeA, nodeB) {
  if (nodeA == null && nodeB == null) {
    return true;
  }

  if (nodeA == null || nodeB == null) {
    return false;
  }

  if (nodeA.nodeType !== nodeB.nodeType) {
    return false;
  }

  // TEXT_NODE
  if (nodeA.nodeType === Node.TEXT_NODE) {
    return nodeA.textContent === nodeB.textContent;
  }

  // ELEMENT_NODE
  if (nodeA.nodeName !== nodeB.nodeName) {
    return false;
  }

  // tagName
  if (nodeA.tagName !== nodeB.tagName) {
    return false;
  }

  // attributes
  const attrA = nodeA.attributes;
  const attrB = nodeB.attributes;

  if (attrA.length !== attrB.length) {
    return false;
  }

  for (let i = 0; i < attrA.length; i++) {
    const attrAName = attrA[i].name;
    const attrAValue = attrA[i].value;
    const attrBValue = nodeB.getAttribute(attrAName);
    if (attrAValue !== attrBValue) {
      return false;
    }
  }

  // childNodes
  const childrenA = nodeA.childNodes;
  const childrenB = nodeB.childNodes;
  if (childrenA.length !== childrenB.length) {
    return false;
  }
  for (let i = 0; i < childrenA.length; i++) {
    if (!identicalDOMTrees(childrenA[i], childrenB[i])) {
      return false;
    }
  }

  return true;
}