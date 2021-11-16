const anagrams = (A) => {

    // insert in hashMap
    let hashMap = new Map();

    for (let i = 0; i < A.length; i++) {
        // sort each string in array
        let str = A[i];
        str = str.split('').sort((a, b) => {
            if (a < b) {
                return -1;
            }
            if (a > b) {
                return 1;
            }
            return 0;
        });
        str = str.join('');

        if (!hashMap.has(str)) {
            hashMap.set(str, [i + 1]);
        } else {
            let arrayIndexes = hashMap.get(str);
            arrayIndexes.push(i + 1);
            hashMap.set(str, arrayIndexes);
        }
    }

    let result = [];
    const keys = hashMap.keys();
    for (let i = 0; i < hashMap.size; i++) {
        const str = keys.next(i).value;
        const value = hashMap.get(str);
        result.push(value);
    }

    console.log(result);
    return result;

}

anagrams(['cat', 'dog', 'god', 'tca']);