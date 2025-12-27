/**
 * @param {Array<string>} items
 * @param {{sorted?: boolean, length?: number, unique?: boolean}} [options]
 * @return {string}
 */
export default function listFormat(items, options) {
  const filteredItems = items.filter((item) => !!item);
  const finalLength =
    options?.length && options?.length > 0
      ? Math.min(options.length, filteredItems.length)
      : filteredItems.length;
  const shouldSort = options?.sorted ?? false;
  const isUniqueArray = options?.unique ?? false;

  let result = [...filteredItems];

  if (isUniqueArray) {
    result = Array.from(new Set(filteredItems));
  }

  if (shouldSort) {
    result.sort();
  }

  if (finalLength === 0) return "";
  if (finalLength === 1) return result[0];

  if (result.length <= finalLength) {
    const allButLast = result.slice(0, result.length - 1);
    const last = result[result.length - 1];
    return `${allButLast.join(", ")} and ${last}`;
  }

  const allExceptOthers = result.slice(0, finalLength);
  const remainingLength = result.length - finalLength;
  const commaSeparated = allExceptOthers.join(", ");
  const answer = [
    commaSeparated,
    `${remainingLength} ${remainingLength === 1 ? "other" : "others"}`,
  ].join(" and ");
  return answer;
}
