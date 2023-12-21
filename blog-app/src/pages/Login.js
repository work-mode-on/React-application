import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "../Components/Base";

const Login =()=>{
    return(
        <Base>
          <Container>
            <Row className="mt-4">
                <Col sm={{size:6,offset:3}} >
                <Card color="dark" outline>
                <CardHeader>
                   <h3>Fill information to Login !!</h3> 
                </CardHeader>
                <CardBody>
                    <Form>
                         {/* Creating Form for Email Field */}
                        <FormGroup> 
                            <Label for="email">Enter Email</Label>
                            <Input type="email" placeholder="Enter here" id ="email"></Input>
                        </FormGroup>
                        {/* Creating Form for Password Field */}
                        <FormGroup> 
                            <Label for="password">Enter Password</Label>
                            <Input type="password" placeholder="Enter Password" id ="password"></Input>
                        </FormGroup>
                        {/* Creating Buttons for Login and Forget password Field */}
                        <Container className="text-center">
                            <Button color="dark">Login</Button>
                            <Button color="secondary" type="reset" className="ms-2">Reset</Button>
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
export default Login