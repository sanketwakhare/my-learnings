// https://codesandbox.io/live/6442b954097?file=/src/index.js

async function sequentialResponse(value, APIs){
    // validations of input
    // type checking

    // first api call (value)

    let data = value;
    for(let i=0; i<APIs.length; i++) {
        console.log(`api#${i}`);
        let response = await callApi(APIs[i], data);
        console.log(`api#${i} response: ${response}`);
        data = response;
    }

}

// service
async function callApi(url, data, options) {
    return setTimeout(() => {
        return Promise.resolve(++data);
    }, 2000)
    // return Promise.resolve(++data);
}


const APIs = ["url1", "url2", "url3", "url4", "url5", "url6"];
sequentialResponse(1, APIs).then((resp) => {
    console.log(resp);
});