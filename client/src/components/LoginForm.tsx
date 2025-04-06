import signUpForm from "./SignUpForm.tsx";
import {Link} from "react-router-dom";

const LoginForm = () => {
    return (
        <div className="flex  items-center justify-center h-screen mt-28">
            <section className="bg-white  p-10 rounded-lg shadow-lg w-2/5">
                <h2 className="font-bold text-2xl mb-4">Log in
                </h2>
                <div className="mt-6 flex items-center justify-center gap-x-6">
                    <Link to={"/sign-up"}>
                    <button
                        type="Sign up"
                        className="text-sm font-semibold leading-6 text-gray-900 bg-gray-400 rounded-md p-2 md-2">
                        Sign up
                    </button>
                    </Link>
                </div>
            </section>
        </div>
    )
}

export default LoginForm