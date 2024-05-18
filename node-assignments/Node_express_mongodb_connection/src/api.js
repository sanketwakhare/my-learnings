const dotenv = require("dotenv");
const express = require("express");
const mongoose = require("mongoose");
const app = express();
const { initializeRoutes } = require("./routes/index");

// Your code goes here
async function connect() {
  try {
    const { DB_USER, DB_PASSWORD, DB_NAME } = process.env;
    const uri = `mongodb+srv://${DB_USER}:${DB_PASSWORD}@cluster-capstone-projec.m4tykul.mongodb.net/${DB_NAME}?retryWrites=true&w=majority`;
    const clientOptions = {
      serverApi: { version: "1", strict: true, deprecationErrors: true },
    };
    // Create a Mongoose client with a MongoClientOptions object to set the Stable API version
    await mongoose.connect(uri, clientOptions);
    await mongoose.connection.db.admin().command({ ping: 1 });
    console.log("You successfully connected to MongoDB!");
  } catch (err) {
    mongoose.disconnect();
    throw err;
  }
}

const initServer = async () => {
  const app = express();

  // Middleware to parse json requests
  app.use(express.json());

  // initialize application-specific routes
  initializeRoutes(app);

  app.listen(3000, () => {
    console.log("Server is running at http://localhost:3000");
  });
};

const initialize = async () => {
  try {
    dotenv.config();
    // connect to mongodb using mongoose ODM
    await connect();
    // start express server
    await initServer();
  } catch (err) {
    console.log(err);
  }
};

initialize();

module.exports = app;
