import GardenList from "../../components/GardenList.tsx";
import React from "react";
import AddGardenForm from "../../components/AddGardenForm.tsx";

const AddGardenPage = () => {


   return (
        <div className="garden-list">
            <h1>Add a garden</h1>
            <AddGardenForm />
        </div>
    );
}

export default AddGardenPage