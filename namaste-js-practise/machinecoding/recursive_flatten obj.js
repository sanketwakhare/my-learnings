let userinput = {
  name: "Sanket",
  address: {
    personal: {
      city: "Yeola",
      area: "Yeola",
    },
    office: {
      city: "Pune",
      area: {
        landmark: "High Streets",
      },
    },
  },
};

// Iterate over each keys
// if value is string, create flat data
// if value is object, iterate over again

console.log(userinput);

const map = new Map(Object.entries(userinput));
console.log(map);

const flatten = function (entry, map) {
  map.set("user_" + entry, entry.value);
};

map.entries().forEach(function () {});
