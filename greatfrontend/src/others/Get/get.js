export function get(objectParam, pathParam, defaultValue) {
  // If the object is null or empty, return the default value
  if (!objectParam || Object.keys(objectParam).length === 0) {
    return defaultValue;
  }

  let objRef = objectParam;
  let tokens = Array.isArray(pathParam) ? pathParam : pathParam.split(".");

  for (let i = 0; i < tokens.length; i++) {
    const currToken = tokens[i];

    // If the current token doesn't exist in the object, return the default value
    if (!objRef || !objRef.hasOwnProperty(currToken)) {
      return defaultValue;
    }
    objRef = objRef[currToken];
  }
  // Return the value found at the specified path
  return objRef;
}
