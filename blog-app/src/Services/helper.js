import axios from "axios";

export const BASE_URL='http://localhost:8000';
export const myAxios= axios.create({
    baseURL:BASE_URL
})

// /api/auth/login
// /api/users/add
