const SignUpForm = () => {
    return (
        <div className="flex  items-center justify-center h-screen mt-28">
            <section className="bg-white  p-10 rounded-lg shadow-lg w-2/5">
                <h2 className="font-bold text-2xl mb-4">Sign up ✏️</h2>
                <form >
                    <div className="space-y-12">
                        <div className="border-b border-gray-900/10 pb-12">
                            <div className="grid grid-cols-1 gap-x-6 gap-y-10 mt-10">
                                <div className="sm:col-span-4">
                                    <label htmlFor="first-name" className="block font-bold mb-2">
                                        First name
                                    </label>
                                    <div className="mt-2">
                                        <div
                                            className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                            <input
                                                id="first-name"
                                                name="first-name"
                                                type="text"
                                                className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                            />
                                        </div>
                                    </div>
                                </div>

                                <div className="sm:col-span-4">
                                    <label htmlFor="last-name" className="block font-bold mb-2">
                                        Last name
                                    </label>
                                    <div className="mt-2">
                                        <div
                                            className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                            <input
                                                id="last-name"
                                                name="last-name"
                                                type="text"
                                                className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                            />
                                        </div>
                                    </div>
                                </div>


                                <div className="col-span-full">
                                    <label htmlFor="bio" className="block font-bold mb-2">
                                        Bio
                                    </label>
                                    <div className="mt-2">
                                        <textarea
                                            id="bio"
                                            name="bio"
                                            rows={4}
                                            className="block w-full rounded-md border-0 py-1.5 text-gray-900 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 focus:ring-2 focus:ring-inset focus:ring-indigo-600 sm:text-sm sm:leading-6"
                                            defaultValue={''}
                                        />
                                    </div>
                                </div>

                                <div className="sm:col-span-4">
                                    <label htmlFor="email" className="block font-bold mb-2">
                                        Email address
                                    </label>
                                    <div className="mt-2">
                                        <div
                                            className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                            <input
                                                id="email"
                                                name="email"
                                                type="text"
                                                className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                            />
                                        </div>
                                    </div>
                                </div>

                                <div className="sm:col-span-4">
                                    <label htmlFor="password" className="block font-bold mb-2">
                                        Password
                                    </label>
                                    <div className="mt-2">
                                        <div
                                            className="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <span
                                        className="flex select-none items-center pl-3 text-gray-500 sm:text-sm"></span>
                                            <input
                                                id="password"
                                                name="password"
                                                type="text"
                                                className="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:ring-0 sm:text-sm sm:leading-6"
                                            />
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div className="mt-6 flex items-center justify-center gap-x-6">
                        <button
                            type="submit"
                            className="text-sm font-semibold leading-6 text-gray-900 bg-gray-400 rounded-md p-2 md-2">
                            Submit
                        </button>
                    </div>
                </form>
            </section>
        </div>
    )
}

export default SignUpForm