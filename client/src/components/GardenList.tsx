import React from 'react'
import {Link} from "react-router-dom";

const GardenList = (props) => {
    const gardens = props.gardens

    console.log(props, gardens)

    return (
        <div className="garden-list">
            {gardens.map(garden => (
                <div key = {garden.id}>

                    <Link to={garden.id} id={garden.id}>
                        {garden.title}
                    </Link>


                </div>
            ))}
        </div>
    )
}

export default GardenList