/**
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