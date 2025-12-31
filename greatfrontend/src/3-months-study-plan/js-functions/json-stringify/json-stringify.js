/**
 * JSON.stringify
 * 
 * Implement a function jsonStringify, similar to JSON.stringify that converts a JavaScript value into a JSON string.

Only JSON-serializable values (i.e. boolean, number, null, array, object) will be present in the input value.
Ignore the second and the third optional parameters in the original API.
Examples

jsonStringify({ foo: 'bar' }); // '{"foo":"bar"}'
jsonStringify({ foo: 'bar', bar: [1, 2, 3] }); // '{"foo":"bar","bar":[1,2,3]}'
jsonStringify({ foo: true, bar: false }); // '{"foo":true,"bar":false}'
Other types


jsonStringify(null); // 'null'
jsonStringify(true); // 'true'
jsonStringify(false); // 'false'
jsonStringify(1); // '1'
jsonStringify('foo'); // '"foo"'
 * 
 */

/**
 * @param {*} value
 * @return {string}
 */
export default function jsonStringify(value) {
  if (Array.isArray(value)) {
    const arrayValues = value.map((x) => jsonStringify(x));
    return `[${arrayValues.join(",")}]`;
  }

  if (typeof value === "object" && value !== null) {
    const objectEntries = Object.entries(value).map(([key, val]) => {
      return `"${key}":${jsonStringify(val)}`;
    });
    return `{${objectEntries.join(",")}}`;
  }

  if (typeof value === "string") {
    return `"${value}"`;
  }

  return String(value);
}
