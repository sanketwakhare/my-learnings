const mongoose = require("mongoose");

const { Schema } = mongoose;

const productSchemaType = {
  name: {
    type: String,
    required: true,
  },
  price: {
    type: Number,
    required: true,
  },
  brand: {
    type: String,
    required: true,
  },
  specs: {
    type: Object,
    required: true,
  },
};

const productSchema = new Schema(productSchemaType);
const Product = mongoose.model("Product", productSchema, "products");

module.exports = Product;
