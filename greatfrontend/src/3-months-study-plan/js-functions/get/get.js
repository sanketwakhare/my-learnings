/**
 * Gets the value at `path` of `object`. If the resolved value is `undefined`,
 * the `defaultValue` is returned in its place.
 * @param {Object} objectParam
 * @param {string|Array<string>} pathParam
 * @param {*} [defaultValue]
 * @return {*}
 */
export default function get(objectParam, pathParam, defaultValue) {

    const tokens = Array.isArray(pathParam) ? pathParam : pathParam.split(".");

    let objRef = objectParam;
    for (const token of tokens) {
        if (!objRef) {
            return defaultValue;
        }

        const keys = Object.keys(objRef);
        const keyArray = Array.from(keys);
        if (keyArray.includes(String(token))) {
            objRef = objRef[token];
        } else {
            return defaultValue;
        }
    }
    return objRef;

}