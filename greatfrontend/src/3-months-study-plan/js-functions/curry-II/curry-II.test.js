import curry from "./curry-II";

const empty = () => 0;
const square = (a) => a * a;
const mul = (a, b) => a * b;
const mulThree = (a, b, c) => a * b * c;

describe("curry", () => {
  test("returns function", () => {
    const curried = curry(square);
    expect(curried).toBeInstanceOf(Function);
  });

  test("empty function", () => {
    const curried = curry(empty);
    expect(curried()).toBe(0);
  });

  test("single argument", () => {
    const curried = curry(square);
    expect(curried()).toBeInstanceOf(Function);
    expect(curried(2)).toBe(4);
  });

  describe("two arguments", () => {
    test("one arg at a time", () => {
      const curried = curry(mul);
      expect(curried()).toBeInstanceOf(Function);
      expect(curried(7)(3)).toBe(21);
    });

    test("both args at once", () => {
      const curried = curry(mul);
      expect(curried()).toBeInstanceOf(Function);
      expect(curried(7, 3)).toBe(21);
    });
  });

  describe("multiple arguments", () => {
    test("one arg at a time", () => {
      const curried = curry(mulThree);
      expect(curried()).toBeInstanceOf(Function);
      expect(curried(7)(3)(2)).toBe(42);
    });

    test("multiple args at once", () => {
      const curried = curry(mulThree);
      expect(curried()).toBeInstanceOf(Function);
      expect(curried(7, 3, 2)).toBe(42);
      expect(curried(7, 3)(2)).toBe(42);
      expect(curried(7)(3, 2)).toBe(42);
    });
  });

  test("can be reused", () => {
    const curried = curry(square);
    expect(curried()).toBeInstanceOf(Function);
    expect(curried(2)).toBe(4);
    expect(curried(3)).toBe(9);
  });

  test("ignores empty args", () => {
    const curried = curry(mulThree);
    expect(curried()(4)()(3)()(2)).toBe(24);
    expect(curried()()()()(4)(2)(3)).toBe(24);
  });
});
