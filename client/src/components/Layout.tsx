import React from 'react'
import {Link, Outlet} from "react-router-dom";

const Layout = () => {
    return (

        <>

        <nav className="flex justify-center items-center w-full bg-white p-3">
            <div
                className="nav-links duration-500 md:static absolute md:min-h-fit min-h-[60vh] left-0 top-[-100%] md:w-auto w-full flex items-center justify-center px-5">
                <ul className="flex md:flex-row flex-col md:items-center md:gap-[4vw] gap-8">
                    <li>
                        <Link to='/add-garden' className="list-none">Add a garden</Link>
                    </li>
                    <li>
                        <Link to='/gardens' className="list-none">Gardens</Link>
                    </li>
                    <li>
                        <a className="hover:text-gray-500" href="#">Link</a>
                    </li>
                    <li>
                        <a className="hover:text-gray-500" href="#">Link</a>
                    </li>
                    <li>
                        <a className="hover:text-gray-500" href="#">Link</a>
                    </li>
                </ul>
            </div>
        </nav>

        <Outlet />
        </>
    )
}

export default Layout



