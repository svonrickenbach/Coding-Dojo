const Product = require('../models/product.model')

// create product
module.exports.createProduct = (request, response) => {
    Product.create(request.body) 
    .then(product => response.json(product))
    .catch(err => response.json(err));
}