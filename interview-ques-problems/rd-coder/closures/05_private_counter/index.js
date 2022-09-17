// Private Counter function

function counter() {

    let _counter = 0;

    const add = (value) => {
        _counter += value;
    }

    const get = (value) => {
        return _counter;
    }

    return {
        add,
        get
    }
}

const cnt = counter();
cnt.add(10);
console.log(cnt.get());
cnt.add(5);
console.log(cnt.get());