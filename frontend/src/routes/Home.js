import React from 'react' 
import homeImage from '../resources/Logo_fertig_2.0_ohne_Hintergrund_weiss.png'

function Home() {
    return (
        <div className='home'>
            <img src={homeImage} style={{ width: '60%' }} />
        </div>
    )
}

export default Home;