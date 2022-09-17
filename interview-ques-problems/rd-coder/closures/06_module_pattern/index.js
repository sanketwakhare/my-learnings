// Module Pattern

const Module = (() => {

    privateFunction = () => {
        console.log("private");
    }

    return {
        publicFunction: () => {
            console.log("public");
            privateFunction();
        }
    };
})();

Module.publicFunction();

// Module.privateFunction(); private methods cannot be invoked from outside