import React from 'react'
import {Link} from "react-router-dom";
import {Garden} from "../pages/gardens/GardensPage.tsx";

const GardenList = (props) => {

    const gardens: Garden[] = props.gardens

    return (
        <div className="garden-list garden-list items-center justify-center mt-20">
            {gardens.map(garden => (
                <div key = {garden.id}>
                    <Link to={`/gardens/${garden.id}`}>
                        <h3 className="p-2">
                            {garden.title}
                        </h3>
                    </Link>
                </div>
            ))}
        </div>
    )
}

export default GardenList