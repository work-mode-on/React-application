import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "../Components/Base";
import { useEffect, useState } from "react";

{/*Component */}
const Signup =()=>{
    const[data,setData] = useState({
        name:'',
        email:'',
        password:'',
        about:'',
    })

    const[error,setError] = useState({
        error:{},
        isError: false
    })

    useEffect(()=>{//using this as callback was not allowed in handlechange method
        console.log(data);
    },[data])

    /* handleChange Listner */
    const handleChange = (event,property)=>{//We can make 4 function for 4 fields or we can use 1 function for all 4 fields
        //We are using property to dynamically change the values 
        setData({...data,[property]:event.target.value
        // setData({...data,name:event.target.value},()=>{/* This function uses asyn operation
        //  thats why we have used call back function with data to print it on console */
        //     console.log(data);
         })
        
        console.log(event.target.value);/* To get the data entered in the field character by character */
     }

        // Resetting the form
    const resetData = () =>{
        setData({
            name:'',
            email:'',
            password:'',
            about:'',
        })
    }

        // Submitting the form
    const submitForm=(event)=>{
        event.preventDefault();
        console.log(data);
        // data Validate

        //call server api for sending data
    }

    return(
        <Base>
            <Container>
                 <Row className="mt-4">
                     {/* {JSON.stringify(data)} */}
                    <Col sm={{size:6,offset:3}} >
                        <Card color="dark" outline>
                            <CardHeader>
                                <h3>Fill information to Register !!</h3> 
                            </CardHeader>
                            <CardBody>
                                <Form onSubmit={submitForm}>
                                        {/* Creating Form for Name Field */}
                                    <FormGroup> {/* Keep 2 things inside it Label and Input component */}
                                            <Label for="name">Enter Name</Label>
                                            <Input type="text" placeholder="Enter here" id="name"
                                            onChange={(e)=>handleChange(e,'name')}
                                            value={data.name}
                                            ></Input>
                                    </FormGroup>
                                        {/* Creating Form for Email Field */}
                                    <FormGroup> 
                                        <Label for="email">Enter Email</Label>
                                        <Input type="email" placeholder="Enter here" id ="email"
                                            onChange={(e)=>handleChange(e,'email')}
                                            value={data.email}></Input>
                                    </FormGroup>
                                        {/* Creating Form for Password Field */}
                                    <FormGroup> 
                                        <Label for="password">Enter Password</Label>
                                        <Input type="password" placeholder="Enter Password" id ="password"
                                            onChange={(e)=>handleChange(e,'password')}
                                            value={data.password}></Input>
                                    </FormGroup>
                                        {/* Creating Form for About Field */}
                                    <FormGroup> 
                                        <Label for="about">Enter Here</Label>
                                        <Input type="textarea" placeholder="Enter here" id ="about"
                                            style={{height:"150px"}}
                                            onChange={(e)=>handleChange(e,'about')}
                                            value={data.about}></Input>
                                    </FormGroup>
                                        {/* Creating Buttons for Signup and Register  Field */}
                                    <Container className="text-center">
                                        <Button color="dark">Register</Button>
                                        <Button onClick={resetData} color="secondary" type="reset" className="ms-2">Reset</Button>
                                    </Container>
                                </Form>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </Base>
    );
};
export default Signup