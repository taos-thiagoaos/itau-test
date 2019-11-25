import React from 'react';
import { Route } from 'react-router-dom';
import { TweetList } from 'components/TweetList';
import { TopFiveFollowersUsersList } from 'components/TopFiveFollowersUsersList';

export function AppRouter() {
  return (
    <div>
      <Route exact path="/" component={TopFiveFollowersUsersList} />
      <Route path="/tweets" component={TweetList} />
    </div>
  );
}
