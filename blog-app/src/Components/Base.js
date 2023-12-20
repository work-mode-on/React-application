import CustomNavbar from "./Navbar";

const Base =({title="Welcome to our Website",children})=>{
    return(
        <div className="container-fluid p-0 m-0">
            <CustomNavbar/>
            {children}
            <h1>This is footer</h1>


        </div>
    );
};
export default Base;