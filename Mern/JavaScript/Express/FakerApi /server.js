const { faker } = require('@faker-js/faker');
const express = require("express");
const app = express();
const port = 8000;

app.use( express.json() );
app.use( express.urlencoded({ extended: true }) );

// req is short for request
// res is short for response

app.get("/api", (req, res) => {
  res.json( "Hello World!" );
});

app.get("/api/user", (req, res) => {
  res.json( newCreateUser );
});

app.get("/api/company", (req, res) => {
  res.json( newCreateCompany );
});

app.get("/api/user/company", (req, res) => {
  res.json({user: newCreateUser, Company: newCreateCompany})
});


const createUser = () => {
  const newUser = {
      password: faker.internet.password(),
      email: faker.internet.email(),
      phone: faker.phone.number(),
      lastName: faker.name.lastName(),
      fristName: faker.name.firstName(),
      id: faker.random.numeric(),
  };
  return newUser;
};
  
const newCreateUser = createUser();
console.log(newCreateUser);

const createCompany = () => {
  const newCompany = {
    id: faker.random.numeric(),
    name: faker.company.name(),
    address: [faker.address.street(), faker.address.city(), faker.address.state(), faker.address.zipCode(), faker.address.country()],
  };
  return newCompany;
};

const newCreateCompany = createCompany();
console.log(newCreateCompany);

app.get("/api", (req, res) => {
  res.json( newUser );
});

// this needs to be below the other code blocks 
app.listen( port, () => console.log(`Listening on port: ${port}`) );