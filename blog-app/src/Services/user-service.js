import { myAxios } from "./helper";

export const signUp = (user) => {
    return myAxios
        .post('/api/auth/login',user)
        .then((response) => response.json())
}