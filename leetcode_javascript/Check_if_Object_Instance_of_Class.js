/**
 * @param {Object} object
 * @param {Function} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function (obj, classFunction) {
    while (obj != null) {
        if (obj.constructor === classFunction) {
            console.log(true);
            return true;
        }
        obj = Object.getPrototypeOf(obj);
    }
    console.log(false);
    return false;
};

/**
 * checkIfInstanceOf(new Date(), Date); // true
 */

checkIfInstanceOf(new Date(), Date);
checkIfInstanceOf(Date(), Date);

function func() {
    class Animal { }; class Dog extends Animal { };
    checkIfInstanceOf(new Dog(), Animal);
}
func();

checkIfInstanceOf(5, Number);
checkIfInstanceOf("5", String);
checkIfInstanceOf(0, Object);
checkIfInstanceOf(undefined, null);