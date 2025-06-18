import React, { useState } from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css';
import '../page css/calendardate.css';

export default function CalendarDate() {
    const [value, setValue] = useState(new Date());  // No type annotations in JS

    return (
        <div className='calenderbox'>
            <Calendar onChange={setValue} value={value} />
        </div>
    );
}
