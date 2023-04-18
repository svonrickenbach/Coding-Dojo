import React, { useState } from 'react'
import axios from 'axios';
const ProductForm = () => {
    
    const [title, setTitle] = useState(""); 
    const [price, setPrice] = useState("");
    const [description, setDescription] = useState("");
    

    const onSubmitHandler = (e) => {
        
        e.preventDefault();

        setTitle({
            title: '',
        });
        setPrice({
            price: 0,
        });
        setDescription({
            description: '',
        });
        
        axios.post('http://localhost:8000/api/product', {
            title,    
            price,
            description      
        })
            .then(res=>{
                console.log(res); 
                console.log(res.data);
            })
            .catch(err=>console.log(err))
    }
    
    return (
        <form onSubmit={onSubmitHandler}>
            <p>
                <label>Title</label><br/>
                <input type="text" onChange = {(e)=>setTitle(e.target.value)} value={title.title}/>
            </p>
            <p>
                <label>Price</label><br/>
                <input type="text" onChange = {(e)=>setPrice(e.target.value)} value={price.price}/>
            </p>
            <p>
                <label>Description</label><br/>
                <input type="text" onChange = {(e)=>setDescription(e.target.value)} value={description.description}/>
            </p>
            <input type="submit"/>
        </form>
    )
}
export default ProductForm;