const shaggyAndDistances = (A) => {

    let ans = A.length;
    let isNoSpecialPair = true;
    // create hashmap
    let hashMap = new Map();
    for (let i = 0; i < A.length; i++) {
        if (!hashMap.has(A[i])) {
            hashMap.set(A[i], i);
        } else {
            const firstIndex = hashMap.get(A[i]);
            ans = Math.min(ans, i - firstIndex);
            hashMap.set(A[i], i);
            isNoSpecialPair = false;
        }
    }
    if (isNoSpecialPair) {
        return -1;
    }
    return ans;
    console.log(ans)
}

shaggyAndDistances([7, 1, 3, 4, 1, 7]);
shaggyAndDistances([1, 1])