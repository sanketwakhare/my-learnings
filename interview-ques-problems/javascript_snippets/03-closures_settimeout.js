const arr = [10, 12, 15, 21];
for (var i = 0; i < arr.length; i++) {
    function print(i) {
        console.log(i)
        setTimeout(function () {
            console.log('Index: ' + i + ', element: ' + arr[i]);
        }, 3000);
    }

    print(i);
}

const arr1 = [10, 12, 15, 21];
for (var i = 0; i < arr1.length; i++) {
    const a = function(i) {
        setTimeout(function () {
            console.log('Index: ' + i + ', element: ' + arr1[i]);
        }, 3000);
    }
    a.bind(this, i)();
}