/*
Fix this interface to make maybeThere optional
*/

//
// interface FooType {
//     maybeThere: Partial<string>;
// }
//
//
// const foo1: FooType = {}; // Bad: maybeThere is not initialized
// const foo2: FooType = { maybeThere: null }; // Bad: maybeThere is not nullable
// const foo3: FooType = { maybeThere: undefined }; // Bad: maybeThere is not nullable