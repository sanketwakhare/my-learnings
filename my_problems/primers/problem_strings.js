function test(A) {
  const tokens = A.split("");

  let counterMap = new Map();
  let count = 0;

  tokens.forEach((token) => {
    if (token === "0") {
      let currentCount = counterMap.has(token) ? counterMap.get(token) : 0;
      counterMap.set(token, ++currentCount);
    } else {
      let currentCount = counterMap.has(token) ? counterMap.get(token) : 0;
      counterMap.set(token, ++currentCount);
    }
    if (counterMap && counterMap.size === 2) {
      const itr = counterMap.values();
      const zeros = itr.next().value;
      const ones = itr.next().value;
      if (zeros && ones && zeros === ones) {
        count++;
        counterMap.clear();
      }
    }
  });
  return count;
}

test("00100000100101111111");
