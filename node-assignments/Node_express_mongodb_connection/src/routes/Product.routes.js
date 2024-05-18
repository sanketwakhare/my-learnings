const express = require("express");

const {
  createProduct,
  getAllProducts,
} = require("../controllers/Product.controller");

const productRoutes = express.Router();

const initRoutes = () => {
  productRoutes.get("/", getAllProducts);
  productRoutes.post("/", createProduct);
};
initRoutes();

module.exports = productRoutes;
