/*******************This file intentional kept empty .
 * this is just a placeholder file that's kept here to represent  ideal folder structure**************/
const productRoutes = require("./Product.routes");

// Middleware to map base url for routes
const initializeRoutes = (app) => {
  app.use("/products", productRoutes);
};

module.exports = { initializeRoutes };
