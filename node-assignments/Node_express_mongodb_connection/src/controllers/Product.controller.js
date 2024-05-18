const Product = require("../models/Product.model");

const createProduct = async (req, res, next) => {
  try {
    const model = new Product(req.body);
    const product = await model.save();
    res.status(201).json(product);
  } catch (err) {
    next(err);
  }
};

const getAllProducts = async (req, res, next) => {
  try {
    res.setHeader("Content-Type", "application/json");
    const products = await Product.find();
    res.status(200).json(products);
  } catch (error) {
    next(error);
  }
};

module.exports = {
  createProduct,
  getAllProducts,
};
