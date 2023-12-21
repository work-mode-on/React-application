import CustomNavbar from "./Navbar";

const Base =({title="Welcome to our Website",children})=>{
    return(
        <div className="container-fluid p-0 m-0">
            <CustomNavbar/>
            {children}
            


        </div>
    );
};
export default Base;