import {parseTime} from '../utils/index.js';

export default {
    formatDate(time) {
        if (time != null && time != undefined && time != '') {
            var date = new Date(time);
            return parseTime(date, '{y}-{m}-{d}');
        }
    },

    formatTimestamp(time) {
        if (time != undefined && time != null) {
            var date = new Date(time);
            return parseTime(date, '{y}-{m}-{d} {h}:{m}:{s}');
        }
    }
}