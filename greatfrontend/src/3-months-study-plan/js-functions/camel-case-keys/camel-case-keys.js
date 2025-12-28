/** 
 * 
 * Camel Case Keys
 * 
 * Implement a function to convert all the keys in an object to camel case
 * 
 * 
 * Implement a function camelCaseKeys, that takes an object and returns a new object with all its keys converted to camel case.

Camel case is a format where words are separated with a single capitalized letter and the first letter of the word will be lower case. Some examples:

String	camelCase
foo	Yes
fooBar	Yes
Foo_Bar	No
foo_bar	No

For simplicity, we only need to consider the 4 string formats above, there will not be keys containing spaces, hyphens, or PascalCase.

camelCaseKeys({ foo_bar: true });
// { fooBar: true }

camelCaseKeys({ foo_bar: true, bar_baz: { baz_qux: '1' } });
// { fooBar: true, barBaz: { bazQux: '1' } }

camelCaseKeys([{ baz_qux: true }, { foo: true, bar: [{ foo_bar: 'hello' }] }]);
// [{ bazQux: true }, { foo: true, bar: [{ fooBar: 'hello' }] }]

*/

const capitalize = (str) => {
  const tokens = str.split("");
  tokens[0] = tokens[0].toUpperCase();
  return tokens.join("");
};

const derivedValue = (value) => {
  if (typeof value === "object") {
    return camelCaseKeys(value);
  }
  return value;
};

/**
 * @param Object
 * @return Object
 */
export default function camelCaseKeys(object) {
  if (Array.isArray(object)) {
    return object.map((x) => camelCaseKeys(x));
  } else if (typeof object === "object") {
    const newObj = {};
    for (const [key, value] of Object.entries(object)) {
      const words = key.split("_");
      if (words.length > 1) {
        words[0] = words[0].toLowerCase();
        for (let i = 1; i < words.length; i++) {
          words[i] = capitalize(words[i]);
        }
        const updatedKey = words.join("");
        newObj[updatedKey] = derivedValue(value);
      } else {
        newObj[key] = derivedValue(value);
      }
    }
    return newObj;
  }
}


/**
 * Alternate Solution
 * 
 * const capitalize = (str: string): string => {
  if (!str) return str;
  return str.charAt(0).toUpperCase() + str.slice(1);
};

const toCamelCase = (key: string): string => {
  const words = key.split("_");
  if (words.length === 1) return key;
  
  return words
    .map((word, index) => 
      index === 0 ? word.toLowerCase() : capitalize(word)
    )
    .join("");
};

export default function camelCaseKeys(value: any): any {
  if (Array.isArray(value)) {
    return value.map((item) => camelCaseKeys(item));
  }
  
  if (value !== null && typeof value === "object") {
    const newObj: Record<string, any> = {};
    
    for (const [key, val] of Object.entries(value)) {
      const camelKey = toCamelCase(key);
      newObj[camelKey] = camelCaseKeys(val);
    }
    
    return newObj;
  }
  
  return value;
}
 */