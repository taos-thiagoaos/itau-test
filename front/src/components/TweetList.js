import Paper from '@material-ui/core/Paper';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Grid from '@material-ui/core/Grid';
import formatDate from 'core/helpers/formatDate';
import formatHour from 'core/helpers/formatHour';
import React, { useEffect, useState } from 'react';
import useStyles from 'styles';
import api from 'core/api';

export function TweetList() {
  const classes = useStyles();

  const [tweetsByTagLang, setTweetsByTagLang] = useState([]);
  const [tweetsByHour, setTweetsByHour] = useState([]);

  useEffect(() => {
    async function fetchData() {
      const resTweetsByTagLang = await api.getTweetsGroupByTagLang();
      resTweetsByTagLang.json()
        .then(data => setTweetsByTagLang(data))
        .catch(err => console.log(err));

      const resTweetsByHour = await api.getTweetsGroupByHour();
      resTweetsByHour.json()
        .then(data => {
          const newData = data.map((tweet) => Object.assign({}, tweet, { date: new Date(tweet.date)}));

          setTweetsByHour(newData)
        })
        .catch(err => console.log(err));
    }

    fetchData();
  }, []);

  return (
    <Grid container spacing={3}>
      <Grid item xs={6}>
        <Paper className={classes.paper}>
          <Table className={classes.table} aria-label="Tweets Por Tag e Idioma">
            <TableHead>
              <TableRow>
                <TableCell>Tag</TableCell>
                <TableCell align="right">Idioma</TableCell>
                <TableCell align="right">Total</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {tweetsByTagLang.map(tweet => (
                <TableRow key={tweet.tag}>
                  <TableCell component="th" scope="row">
                    {tweet.tag}
                  </TableCell>
                  <TableCell align="right">{tweet.lang}</TableCell>
                  <TableCell align="right">{tweet.total}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </Paper>
      </Grid>
      <Grid item xs={6}>
      <Paper className={classes.paper}>
          <Table className={classes.table} aria-label="Tweets por Dia e Hora">
            <TableHead>
              <TableRow>
                <TableCell>Dia</TableCell>
                <TableCell align="right">Hora</TableCell>
                <TableCell align="right">Total</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {tweetsByHour.map(tweet => (
                <TableRow key={tweet.date}>
                  <TableCell component="th" scope="row">
                    {formatDate(tweet.date)}
                  </TableCell>
                  <TableCell align="right">{formatHour(tweet.hour)}</TableCell>
                  <TableCell align="right">{tweet.total}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </Paper>
      </Grid>
    </Grid>
  );
}

