/**
 * getElementsByClassName
 * 
 * Implement a function to get all DOM elements that contain the specified classes
 * 
 * getElementsByClassName() is a method which exists on HTML Documents and Elements to return an HTMLCollection of descendant elements within the Document/Element which has the specified class name(s).

Let's implement our own Element.getElementsByClassName() that is similar but slightly different:

It is a pure function which takes in an element and a classNames string, a string containing one or more class names to match on, separated by whitespace. E.g. getElementsByClassName(document.body, 'foo bar').
Similar to Element.getElementsByClassName(), only descendants of the element argument are searched, not the element itself.
Return an array of Elements, instead of an HTMLCollection of Elements.
Do not use document.querySelectorAll() which will make the problem trivial otherwise. You will not be allowed to use it during real interviews.

Examples

const doc = new DOMParser().parseFromString(
  `<div class="foo bar baz">
    <span class="bar baz">Span</span>
    <p class="foo baz">Paragraph</p>
    <div class="foo bar"></div>
  </div>`,
  'text/html',
);

getElementsByClassName(doc.body, 'foo bar');
// [div.foo.bar.baz, div.foo.bar] <-- This is an array of elements.
 * 
 */

/**
 * @param {Element} element
 * @param {string} classNames
 * @return {Array<Element>}
 */
export default function getElementsByClassName(element, classNames) {
  if (!classNames || !element) return [];

  const desiredClasses = toClassNamesList(classNames);
  if (desiredClasses.length === 0) return [];

  function toClassNamesList(clsNames) {
    return clsNames
      .trim()
      .split(" ")
      .filter((x) => x.length > 0);
  }

  function hasAllClasses(el) {
    const currClasses = toClassNamesList(el.className);
    return desiredClasses.every((cls) => currClasses.includes(cls));
  }

  function traverse(el) {
    for (const child of el.children) {
      if (hasAllClasses(child)) {
        result.push(child);
      }
      traverse(child);
    }
  }

  const result = [];
  traverse(element);
  return result;
}
