import axios from 'axios';
import React, { useEffect, useState } from 'react';
import pexels2 from '../image/pexels2.jpg';
import '../page css/adminpage.css';

export default function AdminPage() {
    const [driverName, setDriverName] = useState('');
    const [trainNo, setTrainNo] = useState('');
    const [trainName, setTrainName] = useState('');
    const [time, setTime] = useState('');
    const [root, setRoot] = useState('');
    const [start_station, setStart_station] = useState('');
    const [date, setDate] = useState('');
    const [dts, setDts] = useState([]);
    const [editid, setEditid] = useState(-1);
    
    // For editing
    const [udriver, setuDriver] = useState('');
    const [utrainName, setuTrainName] = useState('');
    const [utimeshort, setuTimeshort] = useState('');
    const [uroot, setuRoot] = useState('');
    const [ustart_station, setuStart_station] = useState('');
    const [udate, setuDate] = useState('');

    const backendURL = "http://localhost:8080/api/v1/time";

    // Fetch Train Name when Train No changes
    useEffect(() => {
        if (trainNo) {
            axios.get(`http://localhost:8080/api/v1/train/${trainNo}`)
                .then(res => {
                    if (res.data && res.data.name) {
                        setTrainName(res.data.name);
                        setRoot(res.data.main_root);
                    }
                }).catch(err => {
                    console.log("Train not found", err);
                    setTrainName('');
                    setRoot('');
                });
        }
    }, [trainNo]);

    // Save data
    const savedbdata = async () => {
        try {
            const response = await axios.post(`${backendURL}/save`, {
                driverName,
                trainNo,
                trainName,
                root,
                time,
                start_station,
                date,
            });
            alert("Submitted successfully");
            loadTimes();
        } catch (error) {
            console.error("Error submitting:", error);
            alert("Failed to submit data.");
        }
    };

    // Get all records
    async function loadTimes() {
        try {
            const response = await axios.get(`${backendURL}/get`);
            setDts(response.data);
        } catch (error) {
            console.error("Error fetching times:", error);
        }
    }

    useEffect(() => {
        loadTimes();
    }, []);

    // Delete a record
    const hadeldelete = (no) => {
        axios.delete(`${backendURL}/delete/${no}`)
            .then(res => {
                alert("Time entry deleted.");
                loadTimes();
            }).catch(err => console.log(err));
    };

    // Start editing
    const handelEdit = (no) => {
        const data = dts.find(t => t.no === no);
        if (data) {
            setuDriver(data.driverid);
            setuTrainName(data.trainName);
            setuRoot(data.root);
            setuStart_station(data.start_station);
            setuDate(data.date);
            setuTimeshort(data.time);
            setEditid(no);
        }
    };

    // Save update
    const hadelupdate = () => {
        axios.put(`${backendURL}/update`, {
            no: editid,
            driverName: driverName,
            trainName: trainName,
            root: root,
            start_station: start_station,
            date: date,
            time: time
        })
        .then(res => {
            setEditid(-1);
            loadTimes();
        }).catch(err => console.log(err));
    };

    return (
        <div className='admin'>
            <div className="topic">
                <img src={pexels2} />
                <div className='head'>
                    <h1>CREATE TIME SCHEDULE</h1>
                </div>
                <section className='headbutton'>
                    <div className="button">
                        <button type="button" class="btn btn-info" onClick={savedbdata}>Add</button><br/>
                    </div>
                    <div className="adddetail">
                        <label>Driver Id :</label>
                        <input type="number" value={driverName} onChange={(e) => setDriverName(e.target.value)} /><br />
                        <label>Train No :</label>
                        <input type="number" value={trainNo} onChange={(e) => setTrainNo(e.target.value)} />
                        <label className="l1">Train Name :</label>
                        <input type="text" value={trainName} readOnly />
                        <label className="l1">Root :</label>
                        <input type='text' value={root} readOnly /><br />
                        <label >Time :</label>
                        <input type="time" id="tabInput" value={time} onChange={(e) => setTime(e.target.value)} />
                        <label className="l2">Start Station :</label>
                        <input type='text' value={start_station} onChange={(e) => setStart_station(e.target.value)} className="in2" /><br/>
                        <label>Date :</label>
                        <input type='date' id="tabInput" value={date} onChange={(e) => setDate(e.target.value)} />
                    </div>
                </section>
                <div className='tablepart2'>
                    <main className='mainBox2'>
                        <section className='tablehead2'>
                            <h4>Add Time Schedule</h4>
                        </section>
                        <section className='tablebody2'>
                            <table>
                                <thead>
                                    <tr>
                                        <th>No</th>
                                        <th>Driver ID</th>
                                        <th>Train Name</th>
                                        <th>Root</th>
                                        <th>Start Station</th>
                                        <th>Date</th>
                                        <th>Time</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {dts.map((detail) => (
                                        detail.no === editid ? (
                                            <tr key={detail.no}>
                                                <td>{detail.no}</td>
                                                <td><input type='text' value={udriver} onChange={(e) => setuDriver(e.target.value)} /></td>
                                                <td><input type='text' value={utrainName} onChange={(e) => setuTrainName(e.target.value)} /></td>
                                                <td><input type='text' value={uroot} onChange={(e) => setuRoot(e.target.value)} /></td>
                                                <td><input type='text' value={ustart_station} onChange={(e) => setuStart_station(e.target.value)} /></td>
                                                <td><input type='date' value={udate} onChange={(e) => setuDate(e.target.value)} /></td>
                                                <td><input type='text' value={utimeshort} onChange={(e) => setuTimeshort(e.target.value)} /></td>
                                                <td><button className="btn btn-warning" onClick={hadelupdate}>Update</button></td>
                                            </tr>
                                        ) : (
                                            <tr key={detail.no}>
                                                <td>{detail.no}</td>
                                                <td>{detail.driverid}</td>
                                                <td>{detail.trainName}</td>
                                                <td>{detail.root}</td>
                                                <td>{detail.start_station}</td>
                                                <td>{detail.date}</td>
                                                <td>{detail.time}</td>
                                                <td>
                                                    <button className="btn btn-warning" onClick={() => handelEdit(detail.no)}>Edit</button>
                                                    <button className="btn btn-danger" onClick={() => hadeldelete(detail.no)}>Delete</button>
                                                </td>
                                            </tr>
                                        )
                                    ))}
                                </tbody>
                            </table>
                        </section>
                    </main>
                </div>
            </div>
        </div>
    );
}
