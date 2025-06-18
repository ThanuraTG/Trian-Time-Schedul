import React, { useState } from 'react';
import Navi from '../components/Navi';
import video1 from '../image/video1.mp4';
import '../page css/home.css';
import CalendarDate from './CalenderDate';

export default function Home() {

    const [year,setYear]=useState('')
    const [month,setMonth]=useState('')
    const [day,setDay]=useState('')

    const optionsyear =[
        {label:"2019", value:1},
        {label:"2020", value:2},
        {label:"2021", value:3},
        {label:"2022", value:4},
        {label:"2023", value:5},
        {label:"2024", value:6},
        {label:"2026", value:7},
        {label:"2027", value:8},
        {label:"2028", value:9},
        {label:"2029", value:10},
        {label:"2030", value:11},
    ]
    function hadelclick(event){
        setYear(event.target.value)
    }

    const optionsmonth =[
        {label:"January", value:1},
        {label:"Februry", value:2},
        {label:"March", value:3},
        {label:"April", value:4},
        {label:"May", value:5},
        {label:"June", value:6},
        {label:"July", value:7},
        {label:"August", value:8},
        {label:"September", value:9},
        {label:"October", value:10},
        {label:"November", value:11},
        {label:"December", value:12},
    ]
    function hadelclick(event){
        setMonth(event.target.value)
    }

    const optionsday =[
        {label:"01", value:1}, {label:"02", value:2}, {label:"03", value:3},
        {label:"04", value:4}, {label:"05", value:5}, {label:"06", value:6},
        {label:"07", value:7}, {label:"08", value:8}, {label:"09", value:9},
        {label:"10", value:10}, {label:"11", value:11}, {label:"12", value:12},
        {label:"13", value:13}, {label:"14", value:14}, {label:"15", value:15},
        {label:"16", value:16}, {label:"17", value:17}, {label:"18", value:18},
        {label:"19", value:19}, {label:"20", value:20}, {label:"21", value:21},
        {label:"22", value:22}, {label:"23", value:23}, {label:"24", value:24},
        {label:"25", value:25}, {label:"26", value:26}, {label:"27", value:27},
        {label:"28", value:28}, {label:"29", value:29}, {label:"30", value:30},
        {label:"31", value:31},
    ]
    function hadelclick(event){
        setDay(event.target.value)
    }

    return (
        <div className='body'>
            <Navi />
            <div className='headpart'>
                <video src={video1} autoPlay loop muted/>
                <div className='topic'>
                    <h1>TIME SCHEDULE</h1>
                </div>
                <div className="set1">
                    <form>
                        <div className="firstdiv">
                            <h4>Calendar</h4>
                            <CalendarDate />
                        </div>
                        <div className='seconddiv'>
                            <div className="year">
                                <label>Year :</label>
                                <div class="btn-group">
                                    <select className='form-select' onChange={hadelclick} >
                                        {optionsyear.map(option =>(
                                            <option >{option.label}</option>
                                        ))}
                                    </select>
                                </div>
                            </div>
                            <div className="month">
                                <label>Month :</label>
                                <div class="btn-group">
                                    <select className='form-select' onChange={hadelclick} >
                                        {optionsmonth.map(option =>(
                                            <option >{option.label}</option>
                                        ))}
                                    </select>
                                </div>
                            </div>
                            <div className="day">
                                <label>Day :</label>
                                <div class="btn-group">
                                    <select className='form-select' onChange={hadelclick} >
                                        {optionsday.map(option =>(
                                            <option >{option.label}</option>
                                        ))}
                                    </select>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div className='tablepart'>
                    <main className='mainBox'>
                        <section className='tablehead'>
                            <h4>Train Time Table</h4>
                        </section>
                        <section className='tablebody'>
                            <table>
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Driver ID</th>
                                        <th>Train Name</th>
                                        <th>root</th>
                                        <th>Start Station</th>
                                        <th>Time Shot</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </section>
                    </main>
                </div>
            </div>
        </div>
    )
}
