/**
 * @param {Node} nodeA
 * @param {Node} nodeB
 * @return {boolean}
 */
export default function identicalDOMTrees(nodeA, nodeB) {
  // Check if both nodes are null/undefined
  if (nodeA == null && nodeB == null) {
    return true;
  }
  
  // Check if only one node is null/undefined
  if (nodeA == null || nodeB == null) {
    return false;
  }
  
  // Check if node types are different
  if (nodeA.nodeType !== nodeB.nodeType) {
    return false;
  }
  
  // Check if tag names are different (for element nodes)
  if (nodeA.nodeType === Node.ELEMENT_NODE) {
    if (nodeA.tagName !== nodeB.tagName) {
      return false;
    }
    
    // Check if attributes are identical
    if (!hasSameAttributes(nodeA, nodeB)) {
      return false;
    }
  }
  
  // Check if text content is different (for text nodes)
  if (nodeA.nodeType === Node.TEXT_NODE) {
    if (nodeA.textContent !== nodeB.textContent) {
      return false;
    }
  }
  
  // Check if number of children is different
  if (nodeA.childNodes.length !== nodeB.childNodes.length) {
    return false;
  }
  
  // Recursively check all children
  for (let i = 0; i < nodeA.childNodes.length; i++) {
    if (!identicalDOMTrees(nodeA.childNodes[i], nodeB.childNodes[i])) {
      return false;
    }
  }
  
  return true;
}

function hasSameAttributes(nodeA, nodeB) {
  const attrsA = nodeA.attributes;
  const attrsB = nodeB.attributes;
  
  // Check if number of attributes is different
  if (attrsA.length !== attrsB.length) {
    return false;
  }
  
  // Check if all attributes in A exist in B with same values
  for (let i = 0; i < attrsA.length; i++) {
    const attr = attrsA[i];
    const attrValueB = nodeB.getAttribute(attr.name);
    
    if (attrValueB !== attr.value) {
      return false;
    }
  }
  
  return true;
}