/**
 * Implement a function that formats a list of items into a single readable string
 * 
 * 
 * Given a list of strings, implement a function listFormat that returns the items concatenated into a single string. A common use case would be in summarizing the reactions for social media posts.

The function should support a few options as the second parameter:

sorted: Sorts the items by alphabetical order.
length: Show only the first length items, using "and X other(s)" for the remaining. Ignore invalid values (negative, 0, etc).
unique: Remove duplicate items.

Examples

listFormat([]); // ''

listFormat(['Bob']); // 'Bob'
listFormat(['Bob', 'Alice']); // 'Bob and Alice'

listFormat(['Bob', 'Ben', 'Tim', 'Jane', 'John']);
// 'Bob, Ben, Tim, Jane and John'

listFormat(['Bob', 'Ben', 'Tim', 'Jane', 'John'], {
  length: 3,
}); // 'Bob, Ben, Tim and 2 others'

listFormat(['Bob', 'Ben', 'Tim', 'Jane', 'John'], {
  length: 4,
}); // 'Bob, Ben, Tim, Jane and 1 other'

listFormat(['Bob', 'Ben', 'Tim', 'Jane', 'John'], {
  length: 3,
  sorted: true,
}); // 'Ben, Bob, Jane and 2 others'

listFormat(['Bob', 'Ben', 'Tim', 'Jane', 'John', 'Bob'], {
  length: 3,
  unique: true,
}); // 'Bob, Ben, Tim and 2 others'

listFormat(['Bob', 'Ben', 'Tim', 'Jane', 'John'], {
  length: 3,
  unique: true,
}); // 'Bob, Ben, Tim and 2 others'

listFormat(['Bob', 'Ben', '', '', 'John']); // 'Bob, Ben and John'

 * 
 * 
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
