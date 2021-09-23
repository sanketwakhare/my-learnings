const reverseBits = (A) => {
  // convert no to binary string representation
  let N = A.toString(2).padStart(32, "0");

  // reverse the string
  const charArray = N.split("");
  let outString = "";
  for (let i = 0, j = 31; i < 32; i++, j--) {
    let endElement = charArray[j];
    outString = outString + endElement;
  }

  // convert the string representation to decimal
  let decimal = parseInt(outString, 2);
  return decimal;
};

reverseBits(3);
