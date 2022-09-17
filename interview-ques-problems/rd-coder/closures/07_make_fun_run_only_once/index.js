// Make function run only once

const roadSideCoder = () => {
    let isSubscribed = false;

    return function subscribe() {
        if (isSubscribed) {
            console.log("already subscribed")
        } else {
            isSubscribed = true;
            console.log("Subscribed to Road Side Coder");
        }
    }
};

let subscribe = roadSideCoder();
subscribe();
subscribe();
subscribe();
subscribe();

